const express = require("express");
const router = express.Router();

router.get('/', async (req,res,next) => {
    try{
        const youtube_link = [
            "L64t6tuJBXw",
            "1bQk7uSfg-wx",
            "QRvjLoxIuOU",
            "kxgchG3YqZw",
            "bHvT0SNITuU"
        ]
        console.log("성공")
        return res.json({"youtube_link" : youtube_link})
    } catch(error) {
        next(error)
    }
})

module.exports = router;