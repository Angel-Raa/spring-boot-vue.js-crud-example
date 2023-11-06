<script setup lang="ts">
import { ref, type Ref, onMounted } from 'vue'
import { type Employee } from '@/types'
import { getAllEmployee, deleteEmployeeById } from '@/service'
const employees: Ref<Array<Employee>> = ref([])
onMounted(async () => {
  loading()
})
const loading = async () => {
  employees.value = await getAllEmployee()
}
const deleteEmployee = async (employeeId?: number) => {
  console.log(`data de empleado ${employeeId}`)
  if (!employeeId) {
    throw new Error('Employee Id is required')
  }

  await deleteEmployeeById(employeeId)
  loading()
}
</script>

<template>
  <table class="table table:hover">
    <thead class="table-dark">
      <tr>
        <th scope="col">Nombre</th>
        <th scope="col">Apellidos</th>
        <th scope="col">Email</th>
        <th scope="col">departamento</th>
        <th scope="col">Acciones</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="employee in employees" :key="employee.employeeId">
        <td>{{ employee.fistName }}</td>
        <td>{{ employee.lastName }}</td>
        <td>{{ employee.email }}</td>
        <td>{{ employee.department }}</td>
        <td>
          <RouterLink
            :to="{ name: 'edit', params: { id: employee.employeeId } }"
            class="btn btn-primary m-2"
            >Actualizar</RouterLink
          >
          <button
            type="button"
            class="btn btn-danger m-2"
            value="Input"
            @click="deleteEmployee(employee.employeeId)"
          >
            Eliminar
          </button>
        </td>
      </tr>
      <tr v-if="!employees.length">
        <td colspan="5" class="text-center">No hay empleados para mostrar.</td>
      </tr>
    </tbody>
  </table>
</template>
