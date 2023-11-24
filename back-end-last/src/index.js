const express = require('express');
const path = require('path'); //어디서 실행하든 다 되게 하려면 path 모듈 사용 : 절대경로
const app = express();  //앱 객체 생성
const cors = require('cors');
const port = 4000;
const mongoose = require('mongoose');
const dotenv = require('dotenv');
const { router } = require('./routes/youtube');
dotenv.config();

app.use(cors());
app.use(express.json());

mongoose.connect(process.env.MONGO_URI)
    .then(() => {
        console.log('연결완료');
    })  
    .catch(err => {
        console.log(err);
    } )

app.get('/', (req,res, next) => {
    setImmediate(() => {next(new Error('it is an error'))});
    //res.send('Hello, world!하이');
})

app.use("/youtube", require("./routes/youtube"));

app.listen(4000,'0.0.0.0', () => {
    console.log(`${port}번에서 실행이 되었습니다.`);
})