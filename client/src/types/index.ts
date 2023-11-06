export interface Employee {
  employeeId?: number
  fistName?: string
  lastName?: string
  email?: string
  department?: string
}

export interface Response {
  message?: string
  code?: number
  error: boolean
}
