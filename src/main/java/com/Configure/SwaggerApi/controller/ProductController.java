package com.Configure.SwaggerApi.controller;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Operation(summary = "Get all products")
    @GetMapping(path = "/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        try {
            ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
            if (response.getBody().size() < 1) {
                throw new EmptyTableException("No data Products");
            } else {
                return response;
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @Operation(summary = "Get product by Id")
    @GetMapping(path = "/getProduct/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id") Long id) {
        try {
            ResponseEntity<Product> response = new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @Operation(summary = "Add product")
    @PostMapping(path = "/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            ResponseEntity<Product> response = new ResponseEntity<>(productService.addProduct(product), HttpStatus.OK);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @Operation(summary = "Update existing product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) })})
    @PutMapping(path = "/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try {
            ResponseEntity<Product> response = new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
            return response;
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @Operation(summary = "Delete Product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted product",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "invalid id product",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "data not found",
                    content = @Content) })
    @DeleteMapping(path = "/deleteProduct/{id}")
    public ResponseEntity<ResponseMessage> deleteProduct(@Parameter(description = "id of product to be deleted") @PathVariable(name = "id") Long id) {
        ResponseEntity<ResponseMessage> response = new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
        return response;
    }
}

