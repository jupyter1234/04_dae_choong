const { default: mongoose } = require("mongoose");
const bcrypt = require("bcryptjs");

const userSchema = mongoose.Schema({
    user_id: {
        type: String,
        maxLength: 50,
        unique:  1,
        required: true
    },
    password: {
        type: String,
        minLength: 5,
        required: true,
    },
    nickName: {
        type: String,
        required: true,
    },
    email: {
        type: String,
        trim: true,
        unique:  1,
        required: true
    },
    image: String,
    caffeineInfo: {
        type: Array,
        default: []
    }

})



userSchema.pre('save', async function (next) {
    let user = this;

    if (user.isModified('password')) {
        const salt = await bcrypt.genSalt(10);
        const hash = await bcrypt.hash(user.password, salt);
        user.password = hash;
    }

    next();
})

userSchema.methods.comparedPassword = async function (plainPassword) {
    let user = this;
    const match = await bcrypt.compare(plainPassword, user.password);
    return match;
}


const User = mongoose.model("User", userSchema);

module.exports = User;