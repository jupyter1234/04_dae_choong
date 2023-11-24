const express = require("express");
const User = require('../models/User');
const router = express.Router();

//로그인 회원가입 기능

//회원가입 기능
router.post("/register", async(req,res,next) => {
    try{
        const user = new User(req.body);
        console.log(user);
        await user.save()
        
        return res.send(200)
    } catch(error){
        console.log(error);
        res.status(400).send("register failed");
    }
})

//로그인 기능 
router.post('/login',async(req,res,err) => {
    try {
        //console.log(req.body.user_id)
        const user = await User.findOne({
            user_id : req.body.user_id
        })
        //console.log(user);
        if(!user) {
            res.status(400).send("유저가 없습니다");
        }
        const isMatch = await user.comparedPassword(req.body.password);
        if(!isMatch) {
            res.status(401).send("wrong password")
        }
        return res.send(200)
    } catch (error) {
        console.log(error);
        res.status(500).send("login failed")
    }
})
module.exports = router;