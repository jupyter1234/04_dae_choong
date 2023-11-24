const express = require('express');
const CaffeineFood = require('../models/CaffeineFood');
const router = express.Router();

//카페인 음식 검색
router.get('/:searchItem', async(req,res,next) => {
    try {
        const searchItem = req.params.searchItem;
        console.log(searchItem);
        var items = []
        items = await CaffeineFood.find({name: {$regex: searchItem}}, {_id : 0, name: 1, amount: 1});
        console.log(items)
        res.status(200).json({"search_result" : items})
    } catch (error) {
        res.status(421).send("search failed")
        console.log(error)
    }
})

//카페인 음식 생성
router.post('/', async(req,res,next) =>  {
    try {
        const food = new CaffeineFood(req.body);
        await food.save();
        res.sendStatus(200);
    } catch (error) {
        console.log(error);
        res.status(423).send("created failed");
    }
})
module.exports = router;