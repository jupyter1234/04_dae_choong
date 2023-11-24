const { default: mongoose } = require("mongoose");

const caffeineElementSchema = mongoose.Schema({
    
    id: {
        type: ObjectId,
        unique: true,
        require: true
    },
    date: {
        type: Schema.Types.ObjectId,
        ref: "CaffeineInfo",
        required: true,
    },
    user_id: {
        type: Schema.Types.ObjectId,
        ref: "User",
        required: true,
    },
    name: {
        type: Schema.Types.ObjectId,
        ref: "CaffeineFood",
        required: true,
    }
    
})

const CaffeineElement = mongoose.model("CaffeineElement", caffeineElementSchema);
module.exports = CaffeineElement;