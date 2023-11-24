const { default: mongoose, Schema } = require("mongoose");

const caffeineElementSchema = mongoose.Schema({
    
    id: {
        type: Schema.Types.ObjectId,
        unique: true,
        require: true
    },
    date: {
        type: Date,
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
        required: true,
    },
    amount: {
        type: Number,
        required: true,
    }
    
})

const CaffeineElement = mongoose.model("CaffeineElement", caffeineElementSchema);
module.exports = CaffeineElement;