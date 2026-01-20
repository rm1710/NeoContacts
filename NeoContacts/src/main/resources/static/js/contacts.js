console.log("Contacts JS loaded");
const viewContactModal = document.getElementById('view_contact_modal');


// set the modal menu element
const $targetEl = document.getElementById('view_contact_modal');

// options with default values
const options = {
    placement: 'bottom-right',
    backdrop: 'dynamic',
    backdropClasses:
        'bg-gray-900/50 dark:bg-gray-900/80 fixed inset-0 z-40',
    closable: true,
    onHide: () => {
        console.log('modal is hidden');
    },
    onShow: () => {
        console.log('modal is shown');
    },
    onToggle: () => {
        console.log('modal has been toggled');
    },
};

// instance options object
const instanceOptions = {
    id: 'view_contact_modal',
    override: true
};

const contactModal = new Modal(viewContactModal, options, instanceOptions);

function openContactModal() {
    contactModal.show();
}

async function loadContactdata(id) {
    console.log("Load contact data for id:", id);

    try {
        const response = await fetch(`http://localhost:8081/contacts/${id}`);

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        console.log("Contact data loaded:", data);

        // Avatar (with fallback)
        const avatar = document.querySelector('#contact_avatar');
        avatar.src = data.picture && data.picture.trim() !== ""
            ? data.picture
            : "https://via.placeholder.com/150";

        // Basic info
        document.querySelector('#contact_name').textContent = data.name || "N/A";
        document.querySelector('#contact_email').textContent = data.email || "N/A";
        document.querySelector('#contact_phone').textContent = data.phoneNumber || "N/A";
        document.querySelector('#contact_address').textContent = data.address || "N/A";
        document.querySelector('#contact_notes').textContent = data.description || "-";

        const favoriteEl = document.querySelector('#contact_favorite');

        if (data.favorite === true) {
            favoriteEl.classList.remove("hidden");
        } else {
            favoriteEl.classList.add("hidden");
        }

        // Website link
        const websiteEl = document.querySelector('#contact_website');
        if (data.websiteLink) {
            websiteEl.innerHTML = `<a href="${data.
                websiteLink
                }" target="_blank">${data.websiteLink}</a>`;
        } else {
            websiteEl.textContent = "N/A";
        }

        // LinkedIn link
        const linkedinEl = document.querySelector('#contact_linkedin');
        if (data.linkedInLink) {
            linkedinEl.innerHTML = `<a href="${data.linkedInLink}" target="_blank">${data.linkedInLink}</a>`;
        } else {
            linkedinEl.textContent = "N/A";
        }

        // Open modal
        openContactModal();

    } catch (error) {
        console.error("Error loading contact data:", error);
        alert("Failed to load contact details.");
    }
}

function closeContactModal() {
    document.getElementById("view_contact_modal").classList.add("hidden");
}