const { default: mongoose } = require("mongoose");

const caffeineFoodSchema = mongoose.Schema({
    name: {
        type: String,
        unique: 1,
        required: true
    },
    amount: {
        type: Number,
        required: true,
    }

})

const CaffeineFood = mongoose.model("CaffeineFood", caffeineFoodSchema);
module.exports = CaffeineFood;