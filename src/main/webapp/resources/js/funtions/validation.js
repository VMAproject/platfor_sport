/**
 * Created by User on 10.11.2016.
 */
function checkLogin(username) {
    if (username.length < 5) document.getElementById("e_login").style.display = "inline";
    else document.getElementById("e_login").style.display = "none";
}

function checkPassword(password) {
    if (password.length < 5) document.getElementById("e_password").style.display = "inline";
    else document.getElementById("e_password").style.display = "none";
}
function checkEmail(email) {
    if (email.length < 5) document.getElementById("e_email").style.display = "inline";
    else document.getElementById("e_email").style.display = "none";
}

function checkName(name) {
    if (name.length < 5) document.getElementById("e_name").style.display = "inline";
    else document.getElementById("e_name").style.display = "none";
}

function checkSurname(surname) {
    if (surname.length < 5) document.getElementById("e_surname").style.display = "inline";
    else document.getElementById("e_surname").style.display = "none";
}

// function checkPhone(phone) {
//     if (phone.length < 13) document.getElementById("e_phone").style.display = "inline";
//     else document.getElementById("e_phone").style.display = "none";
// }


function checkPhone() {
    var pattern = /^\+?38\(?0\d{2}\)?\d{3}-?\d{2}-?\d{2}$/i;
    var phone = $('#phone');

    if (phone.val() != '') {
        if (phone.val().search(pattern) == 0) {
            $('#e_phone').text('Подходит');

        } else {
            $('#e_phone').text('Не подходит');
        }
    } else {
        $('#e_phone').text('Поле e-mail не должно быть пустым!');
    }
};


function checkLoginA(username) {
    if (username.length < 5) document.getElementById("a_login").style.display = "inline";
    else document.getElementById("a_login").style.display = "none";
}

function checkPasswordA(password) {
    if (password.length < 5) document.getElementById("a_password").style.display = "inline";
    else document.getElementById("a_password").style.display = "none";
}
