const { default: mongoose, Schema } = require("mongoose");

const caffeineElementSchema = mongoose.Schema({
    
    id: {
        type: Schema.ObjectId,
        unique: true,
        require: true
    },
    date: {
        type: String,
        ref: "CaffeineInfo",
        required: true,
    },
    user_id: {
        type: String,
        ref: "User",
        required: true,
    },
    name: {
        type: String,
        ref: "CaffeineFood",
        required: true,
    }
    
})

const CaffeineElement = mongoose.model("CaffeineElement", caffeineElementSchema);
module.exports = CaffeineElement;