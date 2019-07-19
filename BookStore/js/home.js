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

categories.forEach(function(category, index) {
    category = category.toLowerCase().replace(/\s+/g, '_')
    let books = data[category]
    let div = document.getElementById(category+'_div')
    books.forEach(function(book, index) {
        div.innerHTML += 
        `<div class="mdc-card mdc-card__primary-action --mdc-primary-action-radius mdc-elevation--z6 margin--0-10">
            <div class="book-card">
                <div class="book-card-media">
                    <div class="book-card-image">
                        <img src="thumbnails/`+category+'/'+book.image+`" alt="" srcset="">
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
                                        <span class="book-card-book-price">`+book.price+`</span>
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