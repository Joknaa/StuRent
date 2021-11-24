const sign_in_btn = document.querySelector("#sign-in-btn");
const sign_up_btn = document.querySelector("#sign-up-btn");
const container = document.querySelector(".container");


sign_up_btn.addEventListener("click", () => {
    container.classList.add("sign-up-mode");
});

sign_in_btn.addEventListener("click", () => {
    container.classList.remove("sign-up-mode");
});
var pass = document.getElementById("password")
    , confirmPass = document.getElementById("confirmpassword");

function validatePassword(){
    if( pass.value != confirmPass.value) {
        console.log("pass : " + pass)
        console.log("passconf : " + confirmPass)
        confirmPass.setCustomValidity("Passwords Don't Match");
    } else {
        confirmPass.setCustomValidity('');
    }
}

//pass.onchange = validatePassword;
//confirmPass.onkeyup = validatePassword;