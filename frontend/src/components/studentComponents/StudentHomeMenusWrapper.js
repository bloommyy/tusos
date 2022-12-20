import AddFurnitureModal from "./AddFurnitureModal";
import StudentHomeMenu from "./StudentHomeMenu";

function StudentHomeMenusWrapper({ furnitureFlag, btnOnClick }) {
    { !furnitureFlag && <StudentHomeMenu btnOnClick={btnOnClick} /> }
    { furnitureFlag && <AddFurnitureModal closed={btnOnClick} /> }
}
export default StudentHomeMenusWrapper;