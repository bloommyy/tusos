import StudentHomePage from './StudentHomePage'
import HostHomePage from './HostHomePage';

function HomePage() {
    const userJSON = JSON.parse(localStorage.getItem('user'));
    let isStudent = (userJSON.roles[0] === 'ROLE_STUDENT') ? true : false;

    return (
        <div>
            {isStudent && <StudentHomePage />}
            {!isStudent && <HostHomePage />}
        </div>
    )
}

export default HomePage;