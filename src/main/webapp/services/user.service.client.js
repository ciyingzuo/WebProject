function UserServiceClient() {

    this.loginHandler = loginHandler;
    this.registerHandler = registerHandler;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;


    function loginHandler(username, password) {
        var userObj = {
            password: password,
            username: username,
        };
        userObj = JSON.stringify(userObj);
        fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/login', {
            method: 'post',
            body: userObj,
            headers: {'Content-Type': 'application/json'},
            'credentials': 'include'
        }).then(function (response) {
            return response.json();
        }).then(function (user) {
            if (user.password != "") {
            if(user.role == "Faculty"){
            window.location.href = 'https://ciyingzuo-wevdev-hw1.herokuapp.com/whiteboard';
            } else {
                window.location.href = 'user_profile.template.client.html';
            }
            } else {
                alert("username or password incorrect");
            }
        });
    }


    function registerHandler(
        firstName,
        lastName,
        password,
        password2,
        username,
        role,
        phone,
        emailAddress,
        date_of_birth
    ) {
        var userObj = {
            firstName: firstName,
            lastName: lastName,
            password: password,
            username: username,
            role: role,
            phone: phone,
            emailAddress: emailAddress,
            date_of_birth: date_of_birth
        };
        var userObjStr = JSON.stringify(userObj);

        fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/register', {
            method: 'post',
            body: userObjStr,
            headers: {'Content-Type': 'application/json'},
            'credentials': 'include'
        }).then(function (response) {
            return response.json();
        }).then(function (user) {
            if (user.password != "") {
                if (password2 != null && password2 != undefined && password2 != "") {
                    window.location.href = 'user_profile.template.client.html';
                }
            } else {
                alert("username already exist");
            }
        });
    }


    function findAllUsers() {
        return fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/findAll')
            .then(function (response) {
                return response.json();
            });
    }

    function findUserByID(id) {
        fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/findById/' + id).then(function (response) {
            return response.json();
        });
        ;
    }

    function deleteUser(id) {
        fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/delete/' + id, {
            method: 'delete',
            headers: {'Content-Type': 'application/json'}
        }).then(location.reload());
    }


    function updateUser(
        id,
        firstName,
        lastName,
        password,
        username,
        role,
        phone,
        emailAddress,
        date_of_birth
    ) {
        var userObj = {
            id: id,
            firstName: firstName,
            lastName: lastName,
            password: password,
            username: username,
            role: role,
            phone: phone,
            emailAddress: emailAddress,
            date_of_birth: date_of_birth
        };
        var userObjStr = JSON.stringify(userObj);
        fetch('https://ciyingzuo-wevdev-hw1.herokuapp.com/api/user/update/' + id, {
            method: 'put',
            body: userObjStr,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(location.reload());
    }


}