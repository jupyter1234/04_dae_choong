const { default: mongoose } = require("mongoose");

const caffeineInfoSchema = mongoose.Schema({
    date: {
        type : Date,
        unique: true,
        require: true
    },
    user_id: {
        type: Schema.Types.ObjectId,
        ref: "User",
        required: true,
    },
    status: {
        type: String,
        require: true,
    },
    element: {
        type: Array,
        default: []
    }
    
})

const CaffeineInfo = mongoose.model("CaffeineInfo", caffeineInfoSchema);
module.exports = CaffeineInfo;