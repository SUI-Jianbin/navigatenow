import http from 'k6/http';
import {sleep} from 'k6';

export const options = {
    // Key configurations for avg load test in this section
    stages: [
        { duration: '5m', target: 100 }, // traffic ramp-up from 1 to 100 users over 5 minutes.
        { duration: '30m', target: 100 }, // stay at 100 users for 30 minutes
        { duration: '5m', target: 0 }, // ramp-down to 0 users
    ],
};

export default () => {
    const urlRes = http.get('localhost:8080/tripgroups/tripgroup/get-alltripgroup');
    sleep(1);
    // MORE STEPS
    // Add only the processes that will be on high demand
    // Step1
    // Step2
    // etc.
};