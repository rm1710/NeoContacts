console.log("Script loaded successfully.");

let currentTheme = getTheme();
console.log(currentTheme);


document.addEventListener("DOMContentLoaded", () =>{
    changeTheme();
});


function changeTheme() {
    //set to web page 
    document.querySelector("html").classList.add(currentTheme);

    const changeThemeButton = document.querySelector('#theme_change_button');
    changeThemeButton.querySelector("span").textContent = currentTheme === "Light" ? "dark" : "Light";

    changeThemeButton.addEventListener('click', (event) => {
        const oldTheme = currentTheme;
        console.log("Theme change button clicked.");
        if (currentTheme === "dark") {
            currentTheme = "Light";
        } else {
            currentTheme = "dark";
        }

        setTheme(currentTheme);
        document.querySelector("html").classList.remove(oldTheme);
        document.querySelector("html").classList.add(currentTheme);

        changeThemeButton.querySelector("span").textContent = currentTheme === "Light" ? "dark" : "Light";
    });
}



function setTheme(theme) {
    localStorage.setItem("theme", theme);
}

function getTheme() {
    let theme = localStorage.getItem("theme");

    return theme ? theme : "dark";
}


function changePageTheme(theme,oldTheme) {
    setTheme(currentTheme);
    if(oldTheme){
        document.querySelector("html").classList.remove(oldTheme);
    }
    document.querySelector("html").classList.add(theme);

    document.querySelector("#theme_change_button span").querySelector("span").textContent = theme === "Light" ? "dark" : "Light";
}