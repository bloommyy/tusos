import StudentHomePage from './StudentHomePage'

function HomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));
    let isStudent = (userJSON.roles[0] === 'ROLE_STUDENT') ? true : false;

    return (
        <div>
            {isStudent && <StudentHomePage />}
            {/* {!isStudent && <TeacherHomePage />} */}
        </div>
    )
}

export default HomePage;