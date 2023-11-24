const { default: mongoose } = require("mongoose");

const caffeineFoodSchema = mongoose.Schema({
    name: {
        type: String,
        unique: true,
        required: true
    },
    amount: {
        type: Number,
        required: true,
    }
    
})
caffeineFoodSchema.index ({
    name: 'text'
})

const CaffeineFood = mongoose.model("CaffeineFood", caffeineFoodSchema);
module.exports = CaffeineFood;