function validate() {

    //carrot means start with and $ means end with
    var user_name_pattern = /^[A-Za-z]+$/;

   // var email_pattern = /^[A-Za-z]+@gmail.com$/;

    var phone_num_pattern = /[6-9]{1}[0-9]{9}/

    var user_name = document.getElementById("username").value

    if (user_name == "") {
        document.getElementById("msg").innerHTML = "username  is empty"
        return false
    }

    if (user_name.match(user_name_pattern))
        true;
    else {
        document.getElementById("msg").innerHTML = "username should contains  alphabets only"
        return false

    }

    if (user_name.length < 3) {
        document.getElementById("msg").innerHTML = "username must be greater than 3"
        return false
    }

    if (user_name.length > 8) {
        document.getElementById("msg").innerHTML = "username must be less than 8"
        return false
    }



    // for emailId
   /* var email = document.getElementById("email").value

    if (email == "") {
        document.getElementById("msg2").innerHTML = "email  is empty"
        return false
    }

    if (email.match(email_pattern))
        true;
    else {
        document.getElementById("msg2").innerHTML = "email start with alphabets only and ends with @gmail.com"
        return false

    }
    */

    // for phone 
    var phone_num = document.getElementById("phone").value

    if (phone_num.match(phone_num_pattern))
        true;
    else {
        document.getElementById("msg3").innerHTML = "phone invalid"
        return false

    }



}
