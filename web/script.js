document.getElementById("form").addEventListener("submit", function(e){
    e.preventDefault();

    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;

    if(name === "" || email === ""){
        document.getElementById("msg").innerText = "All fields required!";
    } else {
        document.getElementById("msg").innerText = "Form submitted successfully!";
    }
});
