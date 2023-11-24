const mongoose = require("mongoose");

const Youtube = mongoose.Schema({
    id: {
      type: String,
      require: true,
      unique: true
    },
    uri: {
        type: String,
        require: true,
        unique: true
    }
  });
  
module.exports = Youtube;