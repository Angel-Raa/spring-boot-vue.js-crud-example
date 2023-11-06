<script setup lang="ts"></script>

<template>
  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
    <li class="nav-item">
      <RouterLink class="nav-link" :to="{ name: 'home' }" aria-selected="false"> Home </RouterLink>
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link" :to="{ name: 'list' }" aria-selected="false">
        Empleados
      </RouterLink>
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link" :to="{ name: 'create' }" aria-selected="false">
        Servicios
      </RouterLink>
    </li>
  </ul>
</template>
