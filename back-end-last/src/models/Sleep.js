const { default: mongoose, Schema } = require("mongoose");

const sleepSchema = mongoose.Schema({
    date: {
        type: Date,
        required: true
    },
    user_id: {
        type: String,
        ref: "User",
        required: true,
    },
    total_sleep: {
        type: String,
        default: "00:00",
    },
    expect_sleep: {
        type: String,
        default: "",
    },
    memo: {
        type: String,
        maxLength: 300
    }

})

const Sleep = mongoose.model("Sleep", sleepSchema);
module.exports = Sleep;