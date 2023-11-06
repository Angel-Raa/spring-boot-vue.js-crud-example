<script setup lang="ts">
import type { Employee } from '@/types'
import { ref, type Ref, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { updateEmployee, getEmployeeById } from '@/service'
const router = useRoute()
const navigater = useRouter()
const employeeId = +router.params.id
const form: Ref<Employee> = ref({})
onMounted(async () => {
  const employee = await getEmployeeById(employeeId)
  form.value = employee
})
const inputUpdateEmployee = async () => {
  await updateEmployee(form.value, employeeId)
  navigater.push({ name: 'list' })
}
</script>

<template>
  <section class="container">
    <form @submit.prevent="inputUpdateEmployee()">
      <h2 class="text-center">Editar Perfil</h2>
      <div class="form-group">
        <label for="fistName">Nombre</label>
        <input
          id="fistName"
          type="text"
          class="form-control mb-3"
          v-model="form.fistName"
          :required="true"
          :aria-autocomplete="'both'"
        />
      </div>
      <div class="fform-group">
        <label for="lastName">Apellidos</label>
        <input
          id="lastName"
          type="text"
          class="form-control mb-3"
          v-model="form.lastName"
          :required="true"
          :aria-autocomplete="'both'"
        />
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input
          id="email"
          type="email"
          class="form-control mb-3"
          v-model="form.email"
          :required="true"
          :aria-autocomplete="'both'"
        />
      </div>
      <div class="form-group mb-3">
        <label for="department">Departamento</label>
        <select id="department" v-model="form.department" class="form-control">
          <option value="HR">Recurso humano</option>
          <option value="IT">Tecnología de la información</option>
          <option value="AD">Administración</option>
          <option value="FI">Finanzas</option>
          <option value="MA">Marketing</option>
          <option value="SA">Ventas</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Actualizar</button>
    </form>
  </section>
</template>
