/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{js,jsx,ts,tsx}"],
  theme: {
    extend: {
      backgroundImage: {
        laggauage:
          "url('/src/assets/images/travel-concept-with-baggage-passport.jpg')",
        wing: "url('/src/assets/images/airplane-wing-clouds-from-window-view.jpg')",
        flight: "url('/src/assets/images/jumbo-jet-flying-sky.jpg')",
      },
    },
  },
  plugins: [],
};
