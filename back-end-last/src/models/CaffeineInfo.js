const { default: mongoose, Schema } = require("mongoose");

const caffeineInfoSchema = mongoose.Schema({
    date: {
        type : Date,
        unique: true,
        require: true
    },
    user_id: {
        type: String,
        ref: "User",
        required: true,
    },
    status: {
        type: String,
        default: "",
    },
    element: {
        type: Array,
        default: []
    }
    
})

const CaffeineInfo = mongoose.model("CaffeineInfo", caffeineInfoSchema);
module.exports = CaffeineInfo;