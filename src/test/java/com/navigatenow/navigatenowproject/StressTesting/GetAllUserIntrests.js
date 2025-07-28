import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    stages: [
        {duration: '5m', target: 100}, // traffic ramp-up from 1 to 100 users over 5 minutes.
        {duration: '30m', target: 100}, // stay at 100 users for 30 minutes
        {duration: '5m', target: 0}, // ramp-down to 0 users
    ],
};
export default function  () {
    const res = http.get('http://localhost:8080/userintrests/userintrest/get-alluserintrests');
    check(res, { 'status was 200': (r) => r.status == 200 });
    sleep(1);
}


