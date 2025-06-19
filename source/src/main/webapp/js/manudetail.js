document.addEventListener('DOMContentLoaded', () => {
    const stars = document.querySelectorAll('.star');
    const ratingInput = document.getElementById('rating');

    stars.forEach((star, index) => {
        star.addEventListener('click', () => {
            const rating = index + 1;
            ratingInput.value = rating;

            stars.forEach((s, i) => {
                s.style.color = i < rating ? 'gold' : 'gray';
            });
        });
    });
});