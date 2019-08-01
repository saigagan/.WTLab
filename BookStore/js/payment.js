function uniqBy(arr, key) {
    var ids = [];
    
    return arr.filter(function(item) {
        if(ids.includes(item.id))
            return false
        else {
            ids.push(item.id)
            return true;
        }
    })
}

cart = [1, 2, 3, 6, 7]
quantity = [1, 2, 1, 1, 1]
let cart_list = document.getElementById('cart-list')

let data = JSON.parse(books_data)
books = Object.keys(data).map(function(v) {
    return data[v]
})
books = [].concat.apply([], books)
books = uniqBy(books, "id")

orders = books.filter(function(item) {
    return cart.includes(item.id)
})

var total = 0.0

orders.forEach(function(item, index) {
    total += ((quantity[index] == undefined) ? 1: quantity[index]) * item.price
})

delivery = total * 0.1
offers = (total < 25) ? 0 : (total < 50) ? 2.5 : 5
subtotal = total + delivery - offers
taxes_per = (total < 25)? 15 : (total < 100)? 25: 30
taxes = taxes_per / 100 * subtotal
total = subtotal + taxes

document.getElementById('items').innerHTML = cart.length
document.getElementById('price').innerHTML = "$" + total.toFixed(2)
document.getElementById('delivery').innerHTML = "$" + (total * 0.1).toFixed(2)
document.getElementById('offers').innerHTML = "-$" + offers.toFixed(2)
document.getElementById('subtotal').innerHTML = "$" + subtotal.toFixed(2)
document.getElementById('taxes_per').innerHTML = "(" + taxes_per + "%)"
document.getElementById('taxes').innerHTML = "$" + taxes.toFixed(2)
document.getElementById('total').innerHTML = "$" + total.toFixed(2)
document.getElementById('payment_btn_label').innerHTML += " $" + total.toFixed(2)