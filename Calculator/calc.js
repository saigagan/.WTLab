var answer = 0;
var clear = false;
var pop = ''

let output = document.getElementById('output')

function buttonClicked(value) {
    if(clear) 
        output.value = value
    else
        output.value += value
    
    clear = false
}

function operator(op) {
    console.log(output.value)
    switch(pop) {
        case '+':
            answer += parseFloat(output.value)
            break;
        case '-':
            answer -= parseFloat(output.value)
            break;
        case '*':
            answer *= parseFloat(output.value)
            break;
        case '/':
            answer /= parseFloat(output.value)
            break;
        case '':
            answer = parseFloat(output.value)
    }

    pop = op
    showOutput()

    if(op == '=') {
        answer = 0
        pop = ''
    }
}

function showOutput() {
    output.value = answer;
    clear = true;
}