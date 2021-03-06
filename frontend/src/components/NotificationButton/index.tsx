import icon from "../../assets/img/notification-icon.svg"
import './styles.css'
import axios from 'axios';
import { BASE_URL } from "../../utils/request";
import { toast } from "react-toastify";

type Props = {
    salesId: number;
}

function NotificationButton( {salesId} : Props) {
    return (
        <div className="dsmeta-red-btn" onClick={() => handleClick(salesId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )
}

export default NotificationButton

function handleClick(id: number): void {
    axios.get(BASE_URL + "/sales/" + id + "/sendSms")
        .then(() => {
            toast.info("Msn enviado com Sucesso!")

        });
}
