export interface Product {
    code: number,
    name: string,
    type: number,
    brand: string,
    quantityType: number,
    ratePerQunatity: number,
    stockCount: Int16Array,
    addDate: Date,
    aisle: number,
    shelf: number,
    dateOfManufacture: Date,
    dateOfExpiry: Date,
    image: string
}