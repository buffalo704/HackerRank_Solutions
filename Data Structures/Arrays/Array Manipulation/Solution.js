// https://www.hackerrank.com/challenges/crush/problem
'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the arrayManipulation function below.
function arrayManipulation(n, queries) {
    const arr=[];
    let sum = 0;
    let max=0;

    for (let i=0; i< n; i++) {
        arr.push(0);
    }


    for (let query of queries){
        const a = query[0];
        const b = query[1];
        const k = query[2];

        arr[a -1] = arr[a -1] + k;

        if (b < n) {
            arr[b] = arr[b] - k;
        }
    }
    //console.log(arr);

    for (let i = 0; i < n; i++) {
        sum += arr[i];
        if (max < sum) max = sum;
        console.log(sum);
    }

    //console.log(n);
    //console.log(queries);
    //console.log(arr);
    //console.log(Math.max(...arr));
    return max;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nm = readLine().split(' ');

    const n = parseInt(nm[0], 10);

    const m = parseInt(nm[1], 10);

    let queries = Array(m);

    for (let i = 0; i < m; i++) {
        queries[i] = readLine().split(' ').map(queriesTemp => parseInt(queriesTemp, 10));
    }

    let result = arrayManipulation(n, queries);

    ws.write(result + "\n");

    ws.end();
}