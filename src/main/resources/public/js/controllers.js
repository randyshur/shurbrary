angular.module('app.controllers', []).controller('BookListController', function($scope, $state, popupService, $window, Book) {
  $scope.books = Book.query(); //fetch all books. Issues a GET to /api/vi/books

  $scope.deleteBook = function(shipwreck) { // Delete a Book. Issues a DELETE to /api/v1/books/:id
    if (popupService.showPopup('Really delete this?')) {
      shipwreck.$delete(function() {
        $scope.books = Book.query();
        $state.go('books');
      });
    }
  };
}).controller('BookViewController', function($scope, $stateParams, Book) {
  $scope.book = Book.get({ id: $stateParams.id }); //Get a single book.Issues a GET to /api/v1/books/:id
}).controller('BookCreateController', function($scope, $state, $stateParams, Book) {
  $scope.shipwreck = new Book();  //create new book instance. Properties will be set via ng-model on UI

  $scope.addBook = function() { //create a new book. Issues a POST to /api/v1/books
    $scope.book.$save(function() {
      $state.go('books'); // on success go back to the list i.e. books state.
    });
  };
}).controller('BookEditController', function($scope, $state, $stateParams, Book) {
  $scope.updateBook = function() { //Update the edited book. Issues a PUT to /api/v1/books/:id
    $scope.book.$update(function() {
      $state.go('books'); // on success go back to the list i.e. books state.
    });
  };

  $scope.loadBook = function() { //Issues a GET request to /api/v1/books/:id to get a book to update
    $scope.book = Book.get({ id: $stateParams.id });
  };

  $scope.loadBook(); // Load a book which can be edited on UI
});
