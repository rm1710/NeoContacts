console.log("admin");

document.addEventListener("DOMContentLoaded", () => {
    const imageInput = document.querySelector("#image_file_input");
    const imagePreview = document.querySelector("#upload_image_preview");

    if (!imageInput || !imagePreview) return;

    imageInput.addEventListener("change", (event) => {
        const file = event.target.files[0];
        if (!file) return;

        // Optional: validate image type
        if (!file.type.startsWith("image/")) {
            alert("Please select an image file");
            imageInput.value = "";
            return;
        }

        const reader = new FileReader();
        reader.onload = (e) => {
            imagePreview.src = e.target.result;
            imagePreview.classList.remove("hidden"); // Tailwind support
        };

        reader.readAsDataURL(file);
    });
});
