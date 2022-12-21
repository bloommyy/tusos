import AddFurnitureModal from "./AddFurnitureModal";
import StudentHomeMenu from "./StudentHomeMenu";

function StudentHomeMenusWrapper({ furnitureFlag, btnOnClick }) {
    return (
        <div>
            {!furnitureFlag && <StudentHomeMenu btnOnClick={btnOnClick} />}
            {furnitureFlag && <AddFurnitureModal closed={btnOnClick} />}
        </div>
    )
}
export default StudentHomeMenusWrapper;