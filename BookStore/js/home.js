mdc.list.MDCList.attachTo(document.querySelector('.mdc-list')).wrapFocus = true;

let data = JSON.parse(books_data)

let books_section = document.getElementById('books-section')
categories.forEach(function(category, index) {
    books_section.innerHTML +=
        `<h3 class="heading" id="`+category.toLowerCase().replace(/\s+/g, '_')+`">`+category+`</h3>
        <div class="scroll-div" id="`+category.toLowerCase().replace(/\s+/g, '_')+`_div">
                                
        </div>
        `
})

categories.forEach(function(category, cindex) {
    category = category.toLowerCase().replace(/\s+/g, '_')
    let books = data[category]
    let div = document.getElementById(category+'_div')
    books.forEach(function(book, bindex) {
        div.innerHTML += 
        `<div class="mdc-card mdc-card__primary-action --mdc-primary-action-radius mdc-elevation--z6 margin--0-10" onclick="present(`+cindex+`,`+bindex+`)" >
            <div class="book-card">
                <div class="book-card-media">
                    <div class="book-card-image">
                        <img src="thumbnails/`+'/'+book.image+`" alt="" srcset="">
                    </div>
                </div>
                <div class="book-card-content-container">
                    <div class="book-card-content">
                        <div class="book-card-content-table">
                            <div class="book-card-content-table-row">
                                <div class="book-card-content-table-cell">
                                    <div class="book-card-content-details">
                                        <div class="book-card-book-title">`+book.name+`</div>
                                        <div class="book-card-text-fade"></div>
                                    </div>
                                    <div class="book-card-content-details">
                                        <div class="book-card-book-author">`+book.author+`</div>
                                        <div class="book-card-text-fade"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="book-card-content-table-row">
                                <div class="book-card-content-table-cell book-card-book-price-cell">
                                    <div>
                                        <span class="book-card-book-actual-price">`+book.actual_price+`</span>
                                        <span class="book-card-book-price">`+
                                            ((book.price == 0)? "Free":"$" + book.price.toFixed(2))+
                                        `</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>`
    })
})

let model = $("#book-model")
let model_content = $("#book-content")

function present(cindex, bindex) {
    const book = data[categories[cindex].toLowerCase().replace(/\s+/g, '_')][bindex]
    console.log(book)

    $("#model-title").text(book.name)

    model.css('display', 'flex')
}

$(window).click(function(event) {
    console.log(model);
    
    if($(event.target).is(model))
        model.css('display', 'none')
})

$("#close").click(function() {
    model.css('display', 'none')
})