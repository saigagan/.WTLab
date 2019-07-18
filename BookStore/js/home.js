mdc.list.MDCList.attachTo(document.querySelector('.mdc-list')).wrapFocus = true;

let data = JSON.parse(books_data)

/* <div class="mdc-card mdc-card__primary-action --mdc-primary-action-radius mdc-elevation--z6 margin--0-10">
    <div class="book-card">
        <div class="book-card-media">
            <div class="book-card-image">
                <img src="thumbnails/featured/bathbq.jpeg" alt="" srcset="">
            </div>
        </div>
        <div class="book-card-content-container">
            <div class="book-card-content">
                <div class="book-card-content-table">
                    <div class="book-card-content-table-row">
                        <div class="book-card-content-table-cell">
                            <div class="book-card-content-details">
                                <div class="book-card-book-title">Brief Answers to the Big Questions: the final book from Stephen Hawking</div>
                                <div class="book-card-text-fade"></div>
                            </div>
                            <div class="book-card-content-details">
                                <div class="book-card-book-author">Stephen Hawking</div>
                                <div class="book-card-text-fade"></div>
                            </div>
                        </div>
                    </div>
                    <div class="book-card-content-table-row">
                        <div class="book-card-content-table-cell book-card-book-price-cell">
                            <div>
                                <span class="book-card-book-actual-price">$9.99</span>
                                <span class="book-card-book-price">$9.99</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> */

/* <h3 class="heading">Featured Books</h3>
<div class="scroll-div" id="featured">
                        
</div> */

let books_section = document.getElementById('books-section')
categories.forEach(function(category, index) {
    books_section.innerHTML +=
        `<h3 class="heading">`+category+`</h3>
        <div class="scroll-div" id="`+category.toLowerCase()+`">
                                
        </div>
        `
})

categories.forEach(function(category, index) {
    category = category.toLowerCase()
    let books = data[category]
    let div = document.getElementById(category)
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