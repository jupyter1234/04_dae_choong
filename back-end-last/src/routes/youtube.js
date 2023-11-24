const express = require("express");
const router = express.Router();
const mongoose = require("mongoose");


router.get('/', async (req,res,next) => {
    try{
        console.log("성공")
        return res.json({"status" : "success"})
    } catch(error) {
        next(error)
    }
})

module.exports = router;