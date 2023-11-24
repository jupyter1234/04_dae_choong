const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");
const Sleep = require("../models/Sleep");


router.patch('', async (req, res, next) => {
    try {
        const { date, user_id, total_sleep, expect_sleep, memo } = req.body;

        if (!date || !user_id) {
            return res.status(400).json({ error: "date와 user_id를 모두 제공해야 합니다." });
        }

        const updateData = {
            date,
            user_id,
            total_sleep: total_sleep || "00:00",
            expect_sleep: expect_sleep || "",
            memo: memo || ""
        };

        const filter = { date, user_id };

        const options = { upsert: true, new: true, setDefaultsOnInsert: true };

        const updatedSleep = await Sleep.findOneAndUpdate(filter, updateData, options);

        res.status(200).json(updatedSleep);
    } catch (error) {
        console.error(error);
        res.status(430).json({ error: "서버 오류" });
    }
});

module.exports = router;