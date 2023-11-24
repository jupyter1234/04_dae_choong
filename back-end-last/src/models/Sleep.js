const { default: mongoose } = require("mongoose");

const sleepSchema = mongoose.Schema({
    date: {
        type: String,
        unique: 1,
        required: true
    },
    user_id: {
        type: Schema.Types.ObjectId,
        ref: "User",
        required: true,
    },
    total_sleep: {
        type: String,
        required: true,
    },
    expect_sleep: {
        type: String,
        required: true,
    },
    memo: {
        type: String,
        required: true,
        maxLength: 300
    }

})

const Sleep = mongoose.model("Sleep", sleepSchema);
module.exports = Sleep;