function HomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));
    let isStudent = (userJSON.stClass !== undefined) ? true : false;

    return (
        <div>
            tuk shte sa 2te stranici
            {/* {isStudent && <StudentHomePage />} */}
            {/* {!isStudent && <TeacherHomePage />} */}
        </div>
    )
}

export default HomePage;