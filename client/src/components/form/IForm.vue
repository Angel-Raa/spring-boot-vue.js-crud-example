<script setup lang="ts">
import type { Employee } from '@/types'
import { createEmployee } from '@/service'

import { type Ref, ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const form: Ref<Employee> = ref({
  fistName: '',
  lastName: '',
  email: '',
  department: ''
})

const handlerInputForm = async () => {
  await createEmployee(form.value)
  form.value.email = ''
  form.value.lastName = ''
  form.value.fistName = ''
  form.value.department = ''
  router.push({ name: 'list' })
}
</script>

<template>
  <form @submit.prevent="handlerInputForm">
    <h2 class="text-center">Añadiendo empleado</h2>
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
    <button type="submit" class="btn btn-primary">Enviar</button>
  </form>
</template>
