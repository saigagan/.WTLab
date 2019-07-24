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

    cart_list.innerHTML += 
    `<div class="mdc-card mdc-card--outlined cart-item">
        <div class="book-cover">
            <img src="thumbnails/`+item.image+`">
        </div>
        <div class="book-details">
            <h5 class="book-title mdc-typography--headline5">`+item.name+`</h5>
            <h5 class="book-author mdc-typography--subtitle1">`+item.author+`</h5>
            <div class="book-pricing">
                <span>Unit Price: $`+item.price.toFixed(2)+`</span>
                <span>Quantity: `+((quantity[index] == undefined) ? 1: quantity[index])+`</span>
                <span>Price: $`+(((quantity[index] == undefined) ? 1: quantity[index]) * item.price).toFixed(2)+`</span>
                <a class="destructive">Delete</a>
            </div>
        </div>
    </div>`
})

document.getElementById('items').innerHTML = cart.length
document.getElementById('price').innerHTML = "$" + total.toFixed(2)
delivery = total * 0.1
document.getElementById('delivery').innerHTML = "$" + (total * 0.1).toFixed(2)
offers = (total < 25) ? 0 : (total < 50) ? 2.5 : 5
document.getElementById('offers').innerHTML = "-$" + offers.toFixed(2)
subtotal = total + delivery - offers
document.getElementById('subtotal').innerHTML = "$" + subtotal.toFixed(2)
taxes_per = (total < 25)? 15 : (total < 100)? 25: 30
taxes = taxes_per / 100 * subtotal
document.getElementById('taxes_per').innerHTML = "(" + taxes_per + "%)"
document.getElementById('taxes').innerHTML = "$" + taxes.toFixed(2)
total = subtotal + taxes
document.getElementById('total').innerHTML = "$" + total.toFixed(2)
