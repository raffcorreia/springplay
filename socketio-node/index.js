const app = require('express')();
const http = require('http').createServer(app);
const io = require('socket.io')(http, {
    cors: {
        origins: ['http://localhost:4200']
    }
});

app.get('/', (req, res) => {
    res.send('<h1>Hey Socket.io</h1>');
});

io.on('connection', (socket) => {

    console.log('a user ${socket.conn.id} connected');

    socket.on('disconnect', () => {
        console.log('user disconnected');
    });

    socket.on('socketIOEvent', (msg) => {
        sendMessage("Hi there!");
        console.log('message: ' + msg);
    });

    socket.on("join", (roomName) => {
        console.log("join: " + roomName);
        socket.join(roomName);
    });

    socket.on('message', ({ message, roomName }, callback) => {
        console.log("message: " + message + " in " + roomName);
        socket.to(roomName).emit("message", message);
    });

});

http.listen(3000, () => {
    console.log('listening on *:3000');
});

function sendMessage(message) {
    io.emit('socketIOEvent', `${getFullTimestamp()} (server) ${message}`);
}

async function sendRandomMessage() {
    while(true) {
        await sleepNow(Math.floor(Math.random() * 60) * 1000 + 1);
        sendMessage("I am bored :(");
    }
}

const sleepNow = (delay) => new Promise((resolve) => setTimeout(resolve, delay));

function getFullTimestamp() {
    const pad = (n,s=2) => (`${new Array(s).fill(0)}${n}`).slice(-s);
    const d = new Date();

    return `${pad(d.getFullYear(),4)}-${pad(d.getMonth()+1)}-${pad(d.getDate())} ${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}.${pad(d.getMilliseconds(),3)}`;
}

sendRandomMessage();
