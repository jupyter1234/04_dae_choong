const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const CaffeineInfo = require("../models/CaffeineInfo"); 
const Sleep = require("../models/Sleep");
const CaffeineElement = require("../models/CaffeineElement");

router.get('/all', async (req, res, next) => {
    try {
        const { user_id, date } = req.body;

        // 파라미터 검증
        if (!user_id || !date) {
            return res.status(400).json({ error: "user_id와 date를 모두 제공해야 합니다." });
        }

        // YYYY:MM 형태의 date를 YYYY-MM-DD 형태로 변환
        const startDate = new Date(`${date}-01`);
        const endDate = new Date(new Date(startDate).setMonth(startDate.getMonth() + 1) - 1);

        // 해당 user_id와 date 범위에 속하는 CaffeineInfo를 조회
        const existingData = await CaffeineInfo.find({
            user_id,
            date: { $gte: startDate, $lte: endDate }
        });

        // 모든 날짜를 생성
        const allDates = getAllDatesInMonth(startDate);

        // 결과 배열 초기화
        const result = [];

        // 각 날짜에 대해 조회한 데이터가 있는지 확인하고 없으면 새로운 데이터 추가
        for (const d of allDates) {
            const foundData = existingData.find((item) => item.date.toISOString().slice(0, 10) === d.toISOString().slice(0, 10));

            if (foundData) {
                result.push({
                    date: d.getDate(),
                    caf_status: foundData.status
                });
            } else {
                // 새로운 데이터 생성 및 추가
                const newData = new CaffeineInfo({
                    user_id,
                    date: d,
                    status: "",
                    element: []
                });
                await newData.save();

                const newSleep = new Sleep({
                    user_id,
                    date: d
                })
                await newSleep.save();

                result.push({
                    date: d.getDate(),
                    caf_status: newData.status
                });
            }
        }

        res.status(200).json({ all_caf_status: result });
    } catch (error) {
        console.error(error);
        res.status(411).json({ error: "서버 오류" });
    }
});

router.get('/:date', async (req, res, next) => {
    try {
        const date = req.params.date;
        const { user_id } = req.body;

        // CaffeineInfo에서 user_id와 date로 검색
        const caffeineInfoResult = await CaffeineInfo.findOne({ user_id, date });

        // Sleep에서 user_id와 date로 검색
        const sleepResult = await Sleep.findOne({ user_id, date });

        // CaffeineElement에서 user_id와 date로 검색
        const historyResult = await CaffeineElement.find({ user_id, date });

        // historyResult의 name을 리스트로 추출
        const historyNames = historyResult.map(item => item.name);

        // historyResult의 amount를 합산
        const today_caf = historyResult.reduce((sum, item) => sum + item.amount, 0);

        const result = {
            today_caf: today_caf.toString(),  // today_caf를 문자열로 변환
            caf_status: caffeineInfoResult ? caffeineInfoResult.status : "",
            history: historyNames,
            total_sleep: sleepResult ? sleepResult.total_sleep : "",
            expect_sleep: sleepResult ? sleepResult.expect_sleep : "",
            memo: sleepResult ? sleepResult.memo : ""
        };

        res.status(200).json(result);
    } catch (error) {
        console.error(error);
        res.status(411).json({ error: "서버 오류" });
    }
});

// 해당 월의 모든 날짜를 반환하는 함수
function getAllDatesInMonth(startDate) {
    const endDate = new Date(new Date(startDate).setMonth(startDate.getMonth() + 1) - 1);
    const dates = [];
    let currentDate = new Date(startDate);

    while (currentDate <= endDate) {
        dates.push(new Date(currentDate));
        currentDate.setDate(currentDate.getDate() + 1);
    }

    return dates;
}

module.exports = router;