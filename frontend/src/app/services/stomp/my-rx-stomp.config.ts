import { RxStompConfig } from '@stomp/rx-stomp';

export const myRxStompConfig: RxStompConfig = {
    brokerURL: 'ws://localhost:8080/api/stomp',

    connectHeaders: {
        login: 'guest',
        passcode: 'guest',
    },

    heartbeatIncoming: 0, // Typical value 0 - disabled
    heartbeatOutgoing: 20000, // Typical value 20000 - every 20 seconds
    reconnectDelay: 60000,

    debug: (msg: string): void => {
        console.log(new Date(), msg);
    },
};