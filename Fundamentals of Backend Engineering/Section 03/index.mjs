const dgram = require('dgram');

const socet = dgram.createSocket('udp4');
server.bind(5500, "127.0.0.1");
server.on('message', (msg, info) => {
    console.log(`Received message: ${msg} from ${info.address}:${info.port}`);
});

