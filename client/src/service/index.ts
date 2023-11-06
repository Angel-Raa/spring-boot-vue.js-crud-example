import type { Employee, Response } from '@/types'

const BASE_URL = 'http://localhost:9090/api/v1/employee'

export const getAllEmployee = async (): Promise<Array<Employee>> => {
  try {
    const response = await fetch(`${BASE_URL}/all-employee`)
    const data = (await response.json()) as Employee[]
    return data
  } catch (error) {
    throw new Error('Error ')
  }
}

export const getEmployeeById = async (employeeId: number): Promise<Employee> => {
  try {
    const response = await fetch(`${BASE_URL}/employee-by/${employeeId}`)
    const data = (await response.json()) as Employee
    return data
  } catch (error) {
    throw new Error('Error')
  }
}
export const createEmployee = async (employee: Employee): Promise<Response> => {
  try {
    const response = await fetch(`${BASE_URL}/create-employee`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(employee)
    })
    const data = (await response.json()) as Response
    return data
  } catch (error) {
    throw new Error('Error')
  }
}

export const updateEmployee = async (employee: Employee, employeeId: number): Promise<Response> => {
  try {
    const response = await fetch(`${BASE_URL}/update-employee/${employeeId}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(employee)
    })
    const data = (await response.json()) as Response
    return data
  } catch (error) {
    throw new Error('Error')
  }
}

export const deleteEmployeeById = async (employeeId: number): Promise<Response> => {
  try {
    const response = await fetch(`${BASE_URL}/delete-employee/${employeeId}`, {
      method: 'DELETE'
    })
    const data = (await response.json()) as Response
    return data
  } catch (error) {
    throw new Error('Error')
  }
}
